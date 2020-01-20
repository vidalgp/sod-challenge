package sod.vidalgp.challenge;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class SearchData implements Serializable {
    String id_search;
    String label;
    String id_user;
    String id_product;
    Timestamp ts_search;
    Date ds_search;
    Date ds_purchased;
    Date ds_cart;
    String query_market;
    Date query_delivery_date_start;
    Date query_delivery_end_date;
    double query_delivery_radius;
    int query_price_max;
    int query_price_min;
    int product_is_new;
    double product_total_price;
    double product_review_rating;
    int product_review_count;
    int product_type;
    int product_recommended_items;
    boolean product_has_video;
    int product_recent_comments_count;
    int product_recent_comments_count_90d;
    int product_volume_discount;
    int product_bundle_discount;
    double product_short_term_price_factor;
    double product_long_term_price_factor;
    
    public void setId_search(String id_search) {
        this.id_search = id_search;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }
    public void setTs_search(Timestamp ts_search) {
        this.ts_search = ts_search;
    }
    public void setDs_search(Date ds_search) {
        this.ds_search = ds_search;
    }
    public void setDs_purchased(Date ds_purchased) {
        this.ds_purchased = ds_purchased;
    }
    public void setDs_cart(Date ds_cart) {
        this.ds_cart = ds_cart;
    }
    public void setQuery_market(String query_market) {
        this.query_market = query_market;
    }
    public void setQuery_delivery_date_start(Date query_delivery_date_start) {
        this.query_delivery_date_start = query_delivery_date_start;
    }
    public void setQuery_delivery_end_date(Date query_delivery_end_date) {
        this.query_delivery_end_date = query_delivery_end_date;
    }
    public void setQuery_delivery_radius(double query_delivery_radius) {
        this.query_delivery_radius = query_delivery_radius;
    }
    public void setQuery_price_max(int query_price_max) {
        this.query_price_max = query_price_max;
    }
    public void setQuery_price_min(int query_price_min) {
        this.query_price_min = query_price_min;
    }
    public void setProduct_is_new(int product_is_new) {
        this.product_is_new = product_is_new;
    }
    public void setProduct_total_price(double product_total_price) {
        this.product_total_price = product_total_price;
    }
    public void setProduct_review_rating(double product_review_rating) {
        this.product_review_rating = product_review_rating;
    }
    public void setProduct_review_count(int product_review_count) {
        this.product_review_count = product_review_count;
    }
    public void setProduct_type(int product_type) {
        this.product_type = product_type;
    }
    public void setProduct_recommended_items(int product_recommended_items) {
        this.product_recommended_items = product_recommended_items;
    }
    public void setProduct_has_video(boolean product_has_video) {
        this.product_has_video = product_has_video;
    }
    public void setProduct_recent_comments_count(int product_recent_comments_count) {
        this.product_recent_comments_count = product_recent_comments_count;
    }
    public void setProduct_recent_comments_count_90d(int product_recent_comments_count_90d) {
        this.product_recent_comments_count_90d = product_recent_comments_count_90d;
    }
    public void setProduct_volume_discount(int product_volume_discount) {
        this.product_volume_discount = product_volume_discount;
    }
    public void setProduct_bundle_discount(int product_bundle_discount) {
        this.product_bundle_discount = product_bundle_discount;
    }
    public void setProduct_short_term_price_factor(double product_short_term_price_factor) {
        this.product_short_term_price_factor = product_short_term_price_factor;
    }
    public void setProduct_long_term_price_factor(double product_long_term_price_factor) {
        this.product_long_term_price_factor = product_long_term_price_factor;
    }


    public String getId_search() {
        return id_search;
    }
    public String getLabel() {
        return label;
    }
    public String getId_user() {
        return id_user;
    }
    public String getId_product() {
        return id_product;
    }
    public Timestamp getTs_search() {
        return ts_search;
    }
    public Date getDs_search() {
        return ds_search;
    }
    public Date getDs_purchased() {
        return ds_purchased;
    }
    public Date getDs_cart() {
        return ds_cart;
    }
    public String getQuery_market() {
        return query_market;
    }
    public Date getQuery_delivery_date_start() {
        return query_delivery_date_start;
    }
    public Date getQuery_delivery_end_date() {
        return query_delivery_end_date;
    }
    public double getQuery_delivery_radius() {
        return query_delivery_radius;
    }
    public int getQuery_price_max() {
        return query_price_max;
    }
    public int getQuery_price_min() {
        return query_price_min;
    }
    public int getProduct_is_new() {
        return product_is_new;
    }
    public double getProduct_total_price() {
        return product_total_price;
    }
    public double getProduct_review_rating() {
        return product_review_rating;
    }
    public int getProduct_review_count() {
        return product_review_count;
    }
    public int getProduct_type() {
        return product_type;
    }
    public int getProduct_recommended_items() {
        return product_recommended_items;
    }
    public boolean getProduct_has_video() {
        return product_has_video;
    }
    public int getProduct_recent_comments_count() {
        return product_recent_comments_count;
    }
    public int getProduct_recent_comments_count_90d() {
        return product_recent_comments_count_90d;
    }
    public int getProduct_volume_discount() {
        return product_volume_discount;
    }
    public int getProduct_bundle_discount() {
        return product_bundle_discount;
    }
    public double getProduct_short_term_price_factor() {
        return product_short_term_price_factor;
    }
    public double getProduct_long_term_price_factor() {
        return product_long_term_price_factor;
    }

}