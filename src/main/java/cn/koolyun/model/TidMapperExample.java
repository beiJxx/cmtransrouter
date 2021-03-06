package cn.koolyun.model;

import java.util.ArrayList;
import java.util.List;

public class TidMapperExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public TidMapperExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOuterIdIsNull() {
            addCriterion("OUTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOuterIdIsNotNull() {
            addCriterion("OUTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOuterIdEqualTo(String value) {
            addCriterion("OUTER_ID =", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotEqualTo(String value) {
            addCriterion("OUTER_ID <>", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdGreaterThan(String value) {
            addCriterion("OUTER_ID >", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            addCriterion("OUTER_ID >=", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLessThan(String value) {
            addCriterion("OUTER_ID <", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLessThanOrEqualTo(String value) {
            addCriterion("OUTER_ID <=", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLike(String value) {
            addCriterion("OUTER_ID like", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotLike(String value) {
            addCriterion("OUTER_ID not like", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdIn(List<String> values) {
            addCriterion("OUTER_ID in", values, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotIn(List<String> values) {
            addCriterion("OUTER_ID not in", values, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdBetween(String value1, String value2) {
            addCriterion("OUTER_ID between", value1, value2, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotBetween(String value1, String value2) {
            addCriterion("OUTER_ID not between", value1, value2, "outerId");
            return (Criteria) this;
        }

        public Criteria andInterIdIsNull() {
            addCriterion("INTER_ID is null");
            return (Criteria) this;
        }

        public Criteria andInterIdIsNotNull() {
            addCriterion("INTER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andInterIdEqualTo(String value) {
            addCriterion("INTER_ID =", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdNotEqualTo(String value) {
            addCriterion("INTER_ID <>", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdGreaterThan(String value) {
            addCriterion("INTER_ID >", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdGreaterThanOrEqualTo(String value) {
            addCriterion("INTER_ID >=", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdLessThan(String value) {
            addCriterion("INTER_ID <", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdLessThanOrEqualTo(String value) {
            addCriterion("INTER_ID <=", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdLike(String value) {
            addCriterion("INTER_ID like", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdNotLike(String value) {
            addCriterion("INTER_ID not like", value, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdIn(List<String> values) {
            addCriterion("INTER_ID in", values, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdNotIn(List<String> values) {
            addCriterion("INTER_ID not in", values, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdBetween(String value1, String value2) {
            addCriterion("INTER_ID between", value1, value2, "interId");
            return (Criteria) this;
        }

        public Criteria andInterIdNotBetween(String value1, String value2) {
            addCriterion("INTER_ID not between", value1, value2, "interId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOuterSourceIsNull() {
            addCriterion("OUTER_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andOuterSourceIsNotNull() {
            addCriterion("OUTER_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andOuterSourceEqualTo(String value) {
            addCriterion("OUTER_SOURCE =", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceNotEqualTo(String value) {
            addCriterion("OUTER_SOURCE <>", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceGreaterThan(String value) {
            addCriterion("OUTER_SOURCE >", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceGreaterThanOrEqualTo(String value) {
            addCriterion("OUTER_SOURCE >=", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceLessThan(String value) {
            addCriterion("OUTER_SOURCE <", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceLessThanOrEqualTo(String value) {
            addCriterion("OUTER_SOURCE <=", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceLike(String value) {
            addCriterion("OUTER_SOURCE like", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceNotLike(String value) {
            addCriterion("OUTER_SOURCE not like", value, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceIn(List<String> values) {
            addCriterion("OUTER_SOURCE in", values, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceNotIn(List<String> values) {
            addCriterion("OUTER_SOURCE not in", values, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceBetween(String value1, String value2) {
            addCriterion("OUTER_SOURCE between", value1, value2, "outerSource");
            return (Criteria) this;
        }

        public Criteria andOuterSourceNotBetween(String value1, String value2) {
            addCriterion("OUTER_SOURCE not between", value1, value2, "outerSource");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated do_not_delete_during_merge Thu Oct 20 18:07:34 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER.T_ID_MAPPER
     *
     * @mbggenerated Thu Oct 20 18:07:34 CST 2016
     */
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