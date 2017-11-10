import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

/**
  * Created by dshung on 13/08/2017.
  */
trait PersistentModuleDB
{
	private val dbConfig : DatabaseConfig[JdbcProfile]  = DatabaseConfig.forConfig("h2mem1")
	
	val profile: JdbcProfile = dbConfig.driver
	val db: JdbcProfile#Backend#Database = dbConfig.db
}
