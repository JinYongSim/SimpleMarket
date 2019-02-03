package com.scit.SimpleMarket.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.SimpleMarket.PageNavigator.PageNavigator;
import com.scit.SimpleMarket.VO.Product;

@Repository
public class ProductDAO {
	@Autowired
	SqlSession sqlSession;
	// 상품 등록
	public int insertProduct(Product product) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		
		try {
			result = mapper.insertProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 등록 에러");
		}
		return result;
	}
	// 상품 전체리스트 가져오기
	public ArrayList<Product> selectProductListAll(PageNavigator pn,String search){
		ArrayList<Product> list = null;
		RowBounds rb=new RowBounds(pn.getStartBoardPage(),pn.getBoardPerPage()); // startBoardPage 현재페이지의 첫글 위치
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		
		try {
			list = mapper.selectProductListAll(rb,search);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 전체리스트 가져오기 에러");
		}
		return list;
	}
	// 상품 상세보기
	public Product selectProductDetail(String productSeq) {
		Product product = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			product = mapper.selectProductDetail(productSeq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 상세보기 에러");
		}
		return product;
	}
	// 상품 수정
	public void updateProduct(Product product) {
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			mapper.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("상품 수정 에러");
		}
	}
	// 구매정보 등록
	public int insertSold(Product product) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.insertSold(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("구매정보 등록 에러");
		}
		return result;
	}
	// 구매 후 재고 수정
	public void updateProductQuantity(Product product) {
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			mapper.updateProductQuantity(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("구매 후 재고 수정 에러");
		}
	}
	// 재고 수량 확인
	public int checkQuantity(String productSeq) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.checkQuantity(productSeq);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("재고 수량 확인 에러");
		}
		return result;
	}
	// 구매 목록
	public ArrayList<HashMap<String,Object>> selectPurchaseList(String customerId){
		ArrayList<HashMap<String,Object>> hMap = null;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			hMap = mapper.selectPurchaseList(customerId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("구매 목록 에러");
		}
		return hMap;
	}
	
	public int productCount(String search) {
		int result = 0;
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		try {
			result = mapper.productCount(search);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("제품 개수 에러");
		}
		return result;
	}
}
