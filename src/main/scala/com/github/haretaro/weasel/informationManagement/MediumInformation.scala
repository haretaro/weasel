package com.github.haretaro.weasel.informationManagement

import org.aiwolf.common.data.Judge
import org.aiwolf.common.net.GameInfo

/**
  * @author Haretaro
  */
class MediumInformation extends InformationManager{

  var judges = Set.empty[Judge]
  var dateLastUpdated = 0

  override def update(gameInfo: GameInfo): Unit = {
    if(gameInfo.getDay > dateLastUpdated){
      checkMediumResult(gameInfo)
      dateLastUpdated = gameInfo.getDay
    }
  }

  def checkMediumResult(gameInfo: GameInfo): Unit = {
    val judge = gameInfo.getMediumResult
    if (judge != null) {
      judges = judges + judge
      println(judges)
    }
  }

}
