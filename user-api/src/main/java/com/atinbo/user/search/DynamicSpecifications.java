package com.atinbo.user.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DynamicSpecifications {

    public static <T> Specification<T> toSpecification(final QueryParam queryParam) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();
                List<Field> fieldList = ReflectionUtils.getDeclaredFields(queryParam.getClass());

                String fieldName;
                Object fieldValue;
                Query queryMode;
                for (Field field : fieldList) {
                    if (!field.isAnnotationPresent(Query.class)) {
                        continue;
                    }
                    queryMode = field.getAnnotation(Query.class);
                    if (queryMode.ignore()){
                        continue;
                    }
                    fieldName = StringUtils.isBlank(queryMode.field()) ? field.getName() : queryMode.field();
                    fieldValue = ReflectionUtils.invokeGetterMethod(queryParam, field.getName());
                    // logic operator
                    switch (queryMode.operator()) {
                        case EQ:
                            predicates.add(builder.equal(root.get(fieldName), fieldValue));
                            break;
                        case LIKE:
                            predicates.add(builder.like(root.get(fieldName), "%" + fieldValue + "%"));
                            break;
                        case GT:
                            predicates.add(builder.greaterThan(root.get(fieldName), (Comparable) fieldValue));
                            break;
                        case LT:
                            predicates.add(builder.lessThan(root.get(fieldName), (Comparable) fieldValue));
                            break;
                        case GTE:
                            predicates.add(builder.greaterThanOrEqualTo(root.get(fieldName), (Comparable) fieldValue));
                            break;
                        case LTE:
                            predicates.add(builder.lessThanOrEqualTo(root.get(fieldName), (Comparable) fieldValue));
                            break;
                        case NOTNULL:
                            predicates.add(builder.isNotNull(root.get(fieldName)));
                            break;
                        case ISNULL:
                            predicates.add(builder.isNull(root.get(fieldName)));
                            break;
                        case ENUMEQ:
                            predicates.add(builder.equal(root.get(fieldName), fieldValue));
                            break;
                        default:
                            break;
                    }
                }

                // 将所有条件用 and 联合起来
                if (!predicates.isEmpty()) {
                    return builder.and(predicates.toArray(new Predicate[predicates.size()]));
                }

                return builder.conjunction();
            }
        };
    }

}
