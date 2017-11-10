package models

import play.api.Play
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

/**
  * Created by dshung on 25/08/2017.
  */
trait PersistentDatabaseModule
{
	val dbConfig = DatabaseConfigProvider.get[JdbcProfile](Play.current)
	val db: JdbcProfile#Backend#Database = dbConfig.db
}
