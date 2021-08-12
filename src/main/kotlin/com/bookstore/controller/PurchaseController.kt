package com.bookstore.controller

import com.bookstore.controller.mapper.PurchaseMapper
import com.bookstore.controller.request.PostPurchaseRequest
import com.bookstore.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("purchase")
class PurchaseController(
    val purchaseService: PurchaseService,
    val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody request: PostPurchaseRequest){
        purchaseService.create(purchaseMapper.toModel(request))
    }
}