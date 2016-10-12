package com.dengguoxian.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.dengguoxian.model.Product;
import com.dengguoxian.model.ProductForm;

public class SaveProductController implements org.springframework.web.servlet.mvc.Controller {
	private static final Log logger = LogFactory.getLog("SaveProductController called");

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		// 创建model对象
		Product product = new Product();
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		try {
			product.setPrice(Float.parseFloat(productForm.getPrice()));
		} catch (NumberFormatException e) {
			System.out.println("输入的价格有误");
		}
		return new ModelAndView("/jsp/ProductDetails.jsp", "product", product);

	}
}
