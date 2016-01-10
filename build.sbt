scalaVersion := "2.11.7"

mainClass in (Compile, run) := Some("org.aiwolf.server.bin.RoleRequestStarter")

lazy val roleClass = "com.github.haretaro.weasel.Weasel"

lazy val villager = taskKey[Unit]("play as villager")

villager := (runMain in Compile).toTask(" org.aiwolf.server.bin.RoleRequestStarter -n 16 -c "+roleClass + " VILLAGER").value
