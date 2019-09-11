package com.jimmy.learning.app

import org.scalatest.{FlatSpec, Matchers}

class OnlineShoppingServiceSpec extends FlatSpec with Matchers {

  val onlineShoppingService = new OnlineShoppingService

  val orders: Seq[ItemOrder] = Seq(ItemOrder(5, 10), ItemOrder(3, 50), ItemOrder(1, 30))

  "isPurchaseSuccessful" should "only return true if authorisation is successful" in {

    val purchase = PurchaseActivity("Jerry", orders)

    onlineShoppingService.isPurchaseSuccessful(purchase) shouldBe true

  }

  "makePurchase" should "only return true if the customer's name is in the user database AND purchase is successful" in {

    val purchase = PurchaseActivity("Jerry", orders)

    onlineShoppingService.makePurchase(purchase) shouldBe true

  }

  it should "return false if the customer's name is not in the database" in {

    val purchase = PurchaseActivity("Jimmy", orders)

    onlineShoppingService.makePurchase(purchase) shouldBe false

  }

  it should "return false if the purchase is unsuccessful" in {

    val purchase = PurchaseActivity("Jerry", orders.map(item => item.copy(costOfItem = item.costOfItem * 10)))

    onlineShoppingService.makePurchase(purchase) shouldBe false

  }


}
