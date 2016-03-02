package com.github.haretaro.weasel.role

import com.github.haretaro.weasel.informationManagement.MediumInformation
import org.aiwolf.common.data.{Talk, Agent}
import org.aiwolf.common.net.GameInfo

/**
  * @author Haretaro
  */
class Medium extends BasePlayer{

  informationManagers = new MediumInformation :: informationManagers

  override def vote(): Agent = null

  override def divine(): Agent = ???

  override def attack(): Agent = ???

  override def guard(): Agent = ???

  override def talk(): String = Talk.OVER

  override def whisper(): String = ???
}
