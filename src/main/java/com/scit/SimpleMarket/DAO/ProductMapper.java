package com.scit.SimpleMarket.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import com.scit.SimpleMarket.VO.Product;

public interface ProductMapper {
	public int insertProduct(Product product); // 상품 등록
	public ArrayList<Product> selectProductListAll(RowBounds rb,String search); // 상품전체리스트 가져오기
	public Product selectProductDetail(String productSeq); // 상품 상세보기
	public void updateProduct(Product product); // 상품 수정
	public int insertSold(Product product); // 구매정보 등록
	public void updateProductQuantity(Product product); // 구매 후 재고수정
	public int checkQuantity(String productSeq); // 재고 수량 확인
	public ArrayList<HashMap<String,Object>> selectPurchaseList(String customerId); // 구매 목록
	public int productCount(String search); // 제품 개수
}
 