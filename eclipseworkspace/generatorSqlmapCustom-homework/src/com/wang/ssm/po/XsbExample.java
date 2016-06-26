package com.wang.ssm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XsbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public XsbExample() {
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

        public Criteria andXmIsNull() {
            addCriterion("XM is null");
            return (Criteria) this;
        }

        public Criteria andXmIsNotNull() {
            addCriterion("XM is not null");
            return (Criteria) this;
        }

        public Criteria andXmEqualTo(String value) {
            addCriterion("XM =", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotEqualTo(String value) {
            addCriterion("XM <>", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThan(String value) {
            addCriterion("XM >", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmGreaterThanOrEqualTo(String value) {
            addCriterion("XM >=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThan(String value) {
            addCriterion("XM <", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLessThanOrEqualTo(String value) {
            addCriterion("XM <=", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmLike(String value) {
            addCriterion("XM like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotLike(String value) {
            addCriterion("XM not like", value, "xm");
            return (Criteria) this;
        }

        public Criteria andXmIn(List<String> values) {
            addCriterion("XM in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotIn(List<String> values) {
            addCriterion("XM not in", values, "xm");
            return (Criteria) this;
        }

        public Criteria andXmBetween(String value1, String value2) {
            addCriterion("XM between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXmNotBetween(String value1, String value2) {
            addCriterion("XM not between", value1, value2, "xm");
            return (Criteria) this;
        }

        public Criteria andXbIsNull() {
            addCriterion("XB is null");
            return (Criteria) this;
        }

        public Criteria andXbIsNotNull() {
            addCriterion("XB is not null");
            return (Criteria) this;
        }

        public Criteria andXbEqualTo(Byte value) {
            addCriterion("XB =", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotEqualTo(Byte value) {
            addCriterion("XB <>", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThan(Byte value) {
            addCriterion("XB >", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbGreaterThanOrEqualTo(Byte value) {
            addCriterion("XB >=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThan(Byte value) {
            addCriterion("XB <", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbLessThanOrEqualTo(Byte value) {
            addCriterion("XB <=", value, "xb");
            return (Criteria) this;
        }

        public Criteria andXbIn(List<Byte> values) {
            addCriterion("XB in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotIn(List<Byte> values) {
            addCriterion("XB not in", values, "xb");
            return (Criteria) this;
        }

        public Criteria andXbBetween(Byte value1, Byte value2) {
            addCriterion("XB between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andXbNotBetween(Byte value1, Byte value2) {
            addCriterion("XB not between", value1, value2, "xb");
            return (Criteria) this;
        }

        public Criteria andCssjIsNull() {
            addCriterion("CSSJ is null");
            return (Criteria) this;
        }

        public Criteria andCssjIsNotNull() {
            addCriterion("CSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andCssjEqualTo(Date value) {
            addCriterion("CSSJ =", value, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjNotEqualTo(Date value) {
            addCriterion("CSSJ <>", value, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjGreaterThan(Date value) {
            addCriterion("CSSJ >", value, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjGreaterThanOrEqualTo(Date value) {
            addCriterion("CSSJ >=", value, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjLessThan(Date value) {
            addCriterion("CSSJ <", value, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjLessThanOrEqualTo(Date value) {
            addCriterion("CSSJ <=", value, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjIn(List<Date> values) {
            addCriterion("CSSJ in", values, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjNotIn(List<Date> values) {
            addCriterion("CSSJ not in", values, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjBetween(Date value1, Date value2) {
            addCriterion("CSSJ between", value1, value2, "cssj");
            return (Criteria) this;
        }

        public Criteria andCssjNotBetween(Date value1, Date value2) {
            addCriterion("CSSJ not between", value1, value2, "cssj");
            return (Criteria) this;
        }

        public Criteria andZyIsNull() {
            addCriterion("ZY is null");
            return (Criteria) this;
        }

        public Criteria andZyIsNotNull() {
            addCriterion("ZY is not null");
            return (Criteria) this;
        }

        public Criteria andZyEqualTo(String value) {
            addCriterion("ZY =", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotEqualTo(String value) {
            addCriterion("ZY <>", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThan(String value) {
            addCriterion("ZY >", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyGreaterThanOrEqualTo(String value) {
            addCriterion("ZY >=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThan(String value) {
            addCriterion("ZY <", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLessThanOrEqualTo(String value) {
            addCriterion("ZY <=", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyLike(String value) {
            addCriterion("ZY like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotLike(String value) {
            addCriterion("ZY not like", value, "zy");
            return (Criteria) this;
        }

        public Criteria andZyIn(List<String> values) {
            addCriterion("ZY in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotIn(List<String> values) {
            addCriterion("ZY not in", values, "zy");
            return (Criteria) this;
        }

        public Criteria andZyBetween(String value1, String value2) {
            addCriterion("ZY between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andZyNotBetween(String value1, String value2) {
            addCriterion("ZY not between", value1, value2, "zy");
            return (Criteria) this;
        }

        public Criteria andZxfIsNull() {
            addCriterion("ZXF is null");
            return (Criteria) this;
        }

        public Criteria andZxfIsNotNull() {
            addCriterion("ZXF is not null");
            return (Criteria) this;
        }

        public Criteria andZxfEqualTo(Integer value) {
            addCriterion("ZXF =", value, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfNotEqualTo(Integer value) {
            addCriterion("ZXF <>", value, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfGreaterThan(Integer value) {
            addCriterion("ZXF >", value, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZXF >=", value, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfLessThan(Integer value) {
            addCriterion("ZXF <", value, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfLessThanOrEqualTo(Integer value) {
            addCriterion("ZXF <=", value, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfIn(List<Integer> values) {
            addCriterion("ZXF in", values, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfNotIn(List<Integer> values) {
            addCriterion("ZXF not in", values, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfBetween(Integer value1, Integer value2) {
            addCriterion("ZXF between", value1, value2, "zxf");
            return (Criteria) this;
        }

        public Criteria andZxfNotBetween(Integer value1, Integer value2) {
            addCriterion("ZXF not between", value1, value2, "zxf");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
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