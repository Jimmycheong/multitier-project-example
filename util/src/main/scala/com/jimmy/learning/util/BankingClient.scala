package com.jimmy.learning.util

class BankingClient {

  /**
    *
    * Only authorises purchases under 1000
    *
    * @param amount
    * @return Boolean
    */
  def authoriseTranslation(customerName: String, amount: Long): Boolean = {

    AccountHolderBalance.currentBalances.keys.toList.contains(customerName) &&
      amount <= AccountHolderBalance.currentBalances(customerName)

  }



}
