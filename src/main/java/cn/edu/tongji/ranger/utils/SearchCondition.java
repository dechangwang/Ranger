package cn.edu.tongji.ranger.utils;

import cn.edu.tongji.ranger.model.Location;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by daidongyang on 5/15/16.
 */


public class SearchCondition {
    @JsonProperty("search_str")
    private String searchStr;

    @JsonProperty("setoff_location_id")
    private long setoffLoctionId;

    @JsonProperty("first_result")
    private int firstResult = 0;

    @JsonProperty("result_size")
    private int resultSize = 20;

    @JsonProperty("order")
    private SearchProductOrderEnum order = SearchProductOrderEnum.DEFAULT;

    @JsonProperty("min_price")
    private double minPrice = -1;

    @JsonProperty("max_price")
    private double maxPrice = -1;

    @JsonProperty("min_duration")
    private int minDuration = -1;

    @JsonProperty("max_duration")
    private int maxDuration = -1;

    @JsonProperty("limits")
    private String[] limits = null;


    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

    public long getSetoffLoctionId() {
        return setoffLoctionId;
    }

    public void setSetoffLoctionId(long setoffLoctionId) {
        this.setoffLoctionId = setoffLoctionId;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getResultSize() {
        return resultSize;
    }

    public void setResultSize(int resultSize) {
        this.resultSize = resultSize;
    }

    public SearchProductOrderEnum getOrder() {
        return order;
    }

    public void setOrder(SearchProductOrderEnum order) {
        this.order = order;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public int getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public String[] getLimits() {
        return limits;
    }

    public void setLimits(String[] limits) {
        this.limits = limits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchCondition that = (SearchCondition) o;

        if (setoffLoctionId != that.setoffLoctionId) return false;
        if (firstResult != that.firstResult) return false;
        if (resultSize != that.resultSize) return false;
        if (Double.compare(that.minPrice, minPrice) != 0) return false;
        if (Double.compare(that.maxPrice, maxPrice) != 0) return false;
        if (minDuration != that.minDuration) return false;
        if (maxDuration != that.maxDuration) return false;
        if (searchStr != null ? !searchStr.equals(that.searchStr) : that.searchStr != null) return false;
        if (order != that.order) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(limits, that.limits);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = searchStr != null ? searchStr.hashCode() : 0;
        result = 31 * result + (int) (setoffLoctionId ^ (setoffLoctionId >>> 32));
        result = 31 * result + firstResult;
        result = 31 * result + resultSize;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        temp = Double.doubleToLongBits(minPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(maxPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + minDuration;
        result = 31 * result + maxDuration;
        result = 31 * result + Arrays.hashCode(limits);
        return result;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "searchStr='" + searchStr + '\'' +
                ", setoffLoctionId=" + setoffLoctionId +
                ", firstResult=" + firstResult +
                ", resultSize=" + resultSize +
                ", order=" + order +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minDuration=" + minDuration +
                ", maxDuration=" + maxDuration +
                ", limits=" + Arrays.toString(limits) +
                '}';
    }
}
