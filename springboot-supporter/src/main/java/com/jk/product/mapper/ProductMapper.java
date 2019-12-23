package com.jk.product.mapper;

import com.jk.product.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ProductMapper
 * @Description
 * @Author
 * @Date 2019/12/13 10:33
 * @Version V1.0
 **/
public interface ProductMapper {
    /**
     * 新增 地区下拉查询
     * @return
     */
    List<Area> queryArea();

    /**
     * 新增 品牌下拉查询
     * @return
     */
    List<Brand> queryBrand();

    /**
     * 新增商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 商品表查询总条数
     * @param product
     * @return
     */
    Integer queryCount(Product product);

    /**
     * 商品表查询 分页 条查
     * @param start
     * @param limit
     * @param product
     * @return
     */
    List<Product> queryProduct(@Param("s") Integer start, @Param("l")Integer limit, @Param("p")Product product);

    /**
     * 根据商品 表 id 查询 颜色 表
     * @param id
     * @return
     */
    List<Color> queryDetailed(Integer id);

    /**
     * 新增 颜色
     * @param color
     */
    void addColor(Color color);

    /**
     * 删除颜色
     * @param colorid
     */
    void deleteColor(Integer colorid);

    /**
     * 根据颜色id查询 颜色尺码中间表 得到尺码表id集合
     * @param colorid
     * @return
     */
    List<Integer> queryByIds(Integer colorid);

    /**
     * 删除 颜色表下 所有 的 尺码表
     * @param ids
     */
    void deleteSize(List<Integer> ids);

    /**
     * 删除 颜色 尺码 中间表的 数据
     * @param colorid
     */
    void deleteColorSize(Integer colorid);

    /**
     * 根据 颜色id 查询尺码
     * @param id
     * @return
     */
    List<Size> querySize(Integer id);

    /**
     * 新增 尺码
     * @param size
     */
    void addSize(Size size);

    /**
     * 新增 颜色 尺码 中间表
     * @param sizeId
     * @param colorId
     */
    void addColorAndSize(@Param("sizeId") Integer sizeId, @Param("colorId")Integer colorId);

    /**
     * 删除 尺码
     * @param sizeId
     */
    void delSize(Integer sizeId);

    /**
     * 删除 颜色 尺码 中间表
     * @param sizeId
     */
    void delColorSize(Integer sizeId);

    /**
     * 商品 下架
     * @param id
     */
    void lowerShelf(Integer id);

    /**
     * 未上架 商品 总条数
     * @param product
     * @return
     */
    Integer queryCount2(Product product);

    /**
     * 未上架 商品 分页 条查
     * @param start
     * @param limit
     * @param product
     * @return
     */
    List<Product> queryProduct2(@Param("s") Integer start, @Param("l")Integer limit, @Param("p")Product product);

    /**
     * 上架
     * @param id
     */
    void upperShelf(Integer id);

    /**
     * 根据 商品 表 id 查询 商品 下 所有 颜色 表数据
     * @param id
     * @return
     */
    List<Integer> queryColorIdByProductId(Integer id);

    /**
     * 根据 所有 颜色 表 id 拼成字符串 去中间表 查询 所有 对应 尺码表 数据
     * @param substring
     * @return
     */
    List<Integer> querySizeIdByColorId(String substring);

    /**
     * 删除 颜色 表数据
     * @param coloridss
     */
    void delColor(String coloridss);

    /***
     * 删除 中间 表 数据
     * @param coloridss
     */
    void delAllColorSize(String coloridss);

    /**
     * 删除 商品
     * @param id
     */
    void delProduct(Integer id);

    void notAll(@Param("ids") String ids);

    void putAll(@Param("ids")String ids);

    @Select("select * from t_type where brandid = #{id}")
    List<Type> type(Integer id);

    ProductEs queryProductId(Integer id);
}
