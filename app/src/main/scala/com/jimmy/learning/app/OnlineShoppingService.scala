package com.jimmy.learning.app

import com.jimmy.learning.util.BankingClient

case class PurchaseActivity(
                             customerName: String,
                             orders: Seq[ItemOrder]
                   )

case class ItemOrder(
               quantity: Int,
               costOfItem: Int
               )

class OnlineShoppingService {

  val bankingClient = new BankingClient

  def makePurchase(purchase: PurchaseActivity): Boolean = {
    UserDatabase.listOfExistingUsers.contains(purchase.customerName) && isPurchaseSuccessful(purchase)
  }

  def isPurchaseSuccessful(purchase: PurchaseActivity): Boolean = {
    val sumOfOrder = purchase.orders.map(x => x.quantity * x.costOfItem).sum

    bankingClient.authoriseTranslation(purchase.customerName, sumOfOrder)
  }

}
