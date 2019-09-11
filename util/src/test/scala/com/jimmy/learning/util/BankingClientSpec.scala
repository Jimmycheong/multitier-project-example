package com.jimmy.learning.util

import org.scalatest.{Matchers, WordSpec}

class BankingClientSpec extends WordSpec with Matchers {

  "authoriseTranslation" should {

    "return true if the amount is less than or equal to the customer's balance " in {

      val bankingClient = new BankingClient

      bankingClient.authoriseTranslation("Jerry", 200) shouldBe true

    }

    "return false if the amount is greater than the customer's balance" in {

      val bankingClient = new BankingClient

      bankingClient.authoriseTranslation("Jerry", 400) shouldBe false

    }

    "return false if the customer's name does not exist" in {

      val bankingClient = new BankingClient

      bankingClient.authoriseTranslation("Dave", 400) shouldBe false

    }

  }

}
