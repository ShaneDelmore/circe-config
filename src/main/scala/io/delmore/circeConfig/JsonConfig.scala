package io.delmore.circeConfig

import com.typesafe.config.{ Config, ConfigFactory, ConfigRenderOptions }

object JsonConfig {
  val config: Config = ConfigFactory.load
  val configJson: String = config.root.render(ConfigRenderOptions.concise())
}
