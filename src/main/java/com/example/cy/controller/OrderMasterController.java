package com.example.cy.controller;


import com.example.cy.bean.input.OrderMasterInput;
import com.example.cy.bean.query.OrderMasterQuery;
import com.example.cy.service.OrderMasterService;
import com.example.cy.utils.ResponseInfo;
import com.example.cy.utils.page.CommonResponsePage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderMasterController {



    private OrderMasterService orderMasterService;

    /**
     * @Author able-liu
     * @Description /获取汽车并分页可提供指定查询分页
     * @Param
     * @return
     **/
    @RequestMapping(value = "/findAllAndPage", method = RequestMethod.GET)
    public ResponseInfo<?> AllfindAllAndPage (@PageableDefault(page = 1, size = 5) Pageable pageable,
                                              OrderMasterInput input){
        int pageNumber = pageable.getPageNumber();
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        Pageable page = new PageRequest(pageNumber - 1, pageable.getPageSize(), Sort.Direction.DESC, "createdDate");
        CommonResponsePage<OrderMasterQuery> datas = orderMasterService.findOrderMasterAndPage(page, input);
        return ResponseInfo.success(datas);
    }



}
