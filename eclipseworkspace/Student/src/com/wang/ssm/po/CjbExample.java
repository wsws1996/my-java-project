package com.wang.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class CjbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CjbExample() {
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

        public Criteria andXhIsNull() {
            addCriterion("XH is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("XH is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(String value) {
            addCriterion("XH =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(String value) {
            addCriterion("XH <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(String value) {
            addCriterion("XH >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(String value) {
            addCriterion("XH >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(String value) {
            addCriterion("XH <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(String value) {
            addCriterion("XH <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLike(String value) {
            addCriterion("XH like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotLike(String value) {
            addCriterion("XH not like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<String> values) {
            addCriterion("XH in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<String> values) {
            addCriterion("XH not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(String value1, String value2) {
            addCriterion("XH between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(String value1, String value2) {
            addCriterion("XH not between", value1, value2, "xh");
            return (Criteria) this;
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

        public Criteria andCjIsNull() {
            addCriterion("CJ is null");
            return (Criteria) this;
        }

        public Criteria andCjIsNotNull() {
            addCriterion("CJ is not null");
            return (Criteria) this;
        }

        public Criteria andCjEqualTo(Integer value) {
            addCriterion("CJ =", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotEqualTo(Integer value) {
            addCriterion("CJ <>", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjGreaterThan(Integer value) {
            addCriterion("CJ >", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjGreaterThanOrEqualTo(Integer value) {
            addCriterion("CJ >=", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLessThan(Integer value) {
            addCriterion("CJ <", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjLessThanOrEqualTo(Integer value) {
            addCriterion("CJ <=", value, "cj");
            return (Criteria) this;
        }

        public Criteria andCjIn(List<Integer> values) {
            addCriterion("CJ in", values, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotIn(List<Integer> values) {
            addCriterion("CJ not in", values, "cj");
            return (Criteria) this;
        }

        public Criteria andCjBetween(Integer value1, Integer value2) {
            addCriterion("CJ between", value1, value2, "cj");
            return (Criteria) this;
        }

        public Criteria andCjNotBetween(Integer value1, Integer value2) {
            addCriterion("CJ not between", value1, value2, "cj");
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