package com.wang.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class KcbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KcbExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andKchIsNull() {
            addCriterion("KCH is null");
            return (Criteria) this;
        }

        public Criteria andKchIsNotNull() {
            addCriterion("KCH is not null");
            return (Criteria) this;
        }

        public Criteria andKchEqualTo(String value) {
            addCriterion("KCH =", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotEqualTo(String value) {
            addCriterion("KCH <>", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchGreaterThan(String value) {
            addCriterion("KCH >", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchGreaterThanOrEqualTo(String value) {
            addCriterion("KCH >=", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchLessThan(String value) {
            addCriterion("KCH <", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchLessThanOrEqualTo(String value) {
            addCriterion("KCH <=", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchLike(String value) {
            addCriterion("KCH like", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotLike(String value) {
            addCriterion("KCH not like", value, "kch");
            return (Criteria) this;
        }

        public Criteria andKchIn(List<String> values) {
            addCriterion("KCH in", values, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotIn(List<String> values) {
            addCriterion("KCH not in", values, "kch");
            return (Criteria) this;
        }

        public Criteria andKchBetween(String value1, String value2) {
            addCriterion("KCH between", value1, value2, "kch");
            return (Criteria) this;
        }

        public Criteria andKchNotBetween(String value1, String value2) {
            addCriterion("KCH not between", value1, value2, "kch");
            return (Criteria) this;
        }

        public Criteria andKcmIsNull() {
            addCriterion("KCM is null");
            return (Criteria) this;
        }

        public Criteria andKcmIsNotNull() {
            addCriterion("KCM is not null");
            return (Criteria) this;
        }

        public Criteria andKcmEqualTo(String value) {
            addCriterion("KCM =", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotEqualTo(String value) {
            addCriterion("KCM <>", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmGreaterThan(String value) {
            addCriterion("KCM >", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmGreaterThanOrEqualTo(String value) {
            addCriterion("KCM >=", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmLessThan(String value) {
            addCriterion("KCM <", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmLessThanOrEqualTo(String value) {
            addCriterion("KCM <=", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmLike(String value) {
            addCriterion("KCM like", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotLike(String value) {
            addCriterion("KCM not like", value, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmIn(List<String> values) {
            addCriterion("KCM in", values, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotIn(List<String> values) {
            addCriterion("KCM not in", values, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmBetween(String value1, String value2) {
            addCriterion("KCM between", value1, value2, "kcm");
            return (Criteria) this;
        }

        public Criteria andKcmNotBetween(String value1, String value2) {
            addCriterion("KCM not between", value1, value2, "kcm");
            return (Criteria) this;
        }

        public Criteria andKkxqIsNull() {
            addCriterion("KKXQ is null");
            return (Criteria) this;
        }

        public Criteria andKkxqIsNotNull() {
            addCriterion("KKXQ is not null");
            return (Criteria) this;
        }

        public Criteria andKkxqEqualTo(Integer value) {
            addCriterion("KKXQ =", value, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqNotEqualTo(Integer value) {
            addCriterion("KKXQ <>", value, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqGreaterThan(Integer value) {
            addCriterion("KKXQ >", value, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqGreaterThanOrEqualTo(Integer value) {
            addCriterion("KKXQ >=", value, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqLessThan(Integer value) {
            addCriterion("KKXQ <", value, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqLessThanOrEqualTo(Integer value) {
            addCriterion("KKXQ <=", value, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqIn(List<Integer> values) {
            addCriterion("KKXQ in", values, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqNotIn(List<Integer> values) {
            addCriterion("KKXQ not in", values, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqBetween(Integer value1, Integer value2) {
            addCriterion("KKXQ between", value1, value2, "kkxq");
            return (Criteria) this;
        }

        public Criteria andKkxqNotBetween(Integer value1, Integer value2) {
            addCriterion("KKXQ not between", value1, value2, "kkxq");
            return (Criteria) this;
        }

        public Criteria andXsIsNull() {
            addCriterion("XS is null");
            return (Criteria) this;
        }

        public Criteria andXsIsNotNull() {
            addCriterion("XS is not null");
            return (Criteria) this;
        }

        public Criteria andXsEqualTo(Integer value) {
            addCriterion("XS =", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsNotEqualTo(Integer value) {
            addCriterion("XS <>", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsGreaterThan(Integer value) {
            addCriterion("XS >", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsGreaterThanOrEqualTo(Integer value) {
            addCriterion("XS >=", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsLessThan(Integer value) {
            addCriterion("XS <", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsLessThanOrEqualTo(Integer value) {
            addCriterion("XS <=", value, "xs");
            return (Criteria) this;
        }

        public Criteria andXsIn(List<Integer> values) {
            addCriterion("XS in", values, "xs");
            return (Criteria) this;
        }

        public Criteria andXsNotIn(List<Integer> values) {
            addCriterion("XS not in", values, "xs");
            return (Criteria) this;
        }

        public Criteria andXsBetween(Integer value1, Integer value2) {
            addCriterion("XS between", value1, value2, "xs");
            return (Criteria) this;
        }

        public Criteria andXsNotBetween(Integer value1, Integer value2) {
            addCriterion("XS not between", value1, value2, "xs");
            return (Criteria) this;
        }

        public Criteria andXfIsNull() {
            addCriterion("XF is null");
            return (Criteria) this;
        }

        public Criteria andXfIsNotNull() {
            addCriterion("XF is not null");
            return (Criteria) this;
        }

        public Criteria andXfEqualTo(Integer value) {
            addCriterion("XF =", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfNotEqualTo(Integer value) {
            addCriterion("XF <>", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfGreaterThan(Integer value) {
            addCriterion("XF >", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfGreaterThanOrEqualTo(Integer value) {
            addCriterion("XF >=", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfLessThan(Integer value) {
            addCriterion("XF <", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfLessThanOrEqualTo(Integer value) {
            addCriterion("XF <=", value, "xf");
            return (Criteria) this;
        }

        public Criteria andXfIn(List<Integer> values) {
            addCriterion("XF in", values, "xf");
            return (Criteria) this;
        }

        public Criteria andXfNotIn(List<Integer> values) {
            addCriterion("XF not in", values, "xf");
            return (Criteria) this;
        }

        public Criteria andXfBetween(Integer value1, Integer value2) {
            addCriterion("XF between", value1, value2, "xf");
            return (Criteria) this;
        }

        public Criteria andXfNotBetween(Integer value1, Integer value2) {
            addCriterion("XF not between", value1, value2, "xf");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}