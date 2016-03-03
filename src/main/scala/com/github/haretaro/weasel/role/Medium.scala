package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.informationManagement.MediumInformation
import org.aiwolf.client.lib.TemplateTalkFactory
import org.aiwolf.common.data.{Role, Talk, Agent}
import org.aiwolf.common.net.{GameSetting, GameInfo}

/**
  * @author Haretaro
  */
class Medium extends BasePlayer{

  var mediumInformation: MediumInformation = null

  var isComingout = false

  override def initialize(gameInfo: GameInfo, gameSetting: GameSetting) = {
    super.initialize(gameInfo, gameSetting)
    mediumInformation = new MediumInformation
  }

  override def vote(): Agent = null

  override def divine(): Agent = ???

  override def attack(): Agent = ???

  override def guard(): Agent = ???

  override def talk(): String = {
    println(gameInformation.me)

    def comingout = if(isComingout == false) {
        isComingout = true
        Some(TemplateTalkFactory.comingout(gameInformation.me, Role.MEDIUM))
      }else None

    comingout getOrElse Talk.OVER
  }

  override def update(gameInfo: GameInfo) = {
    super.update(gameInfo)
    mediumInformation.update(gameInfo)
  }

  override def whisper(): String = ???
}
