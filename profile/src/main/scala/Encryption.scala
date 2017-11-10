/**
  * Created by dshung on 09/09/2017.
  */

import com.roundeights.hasher.{Hasher, Algo}
import scala.language.postfixOps

object Encryption
{
	def createSalt(date: String): String = Algo.sha256(date).hex
	
	def encryptPassword(password: String, salt: String) = Algo.sha256(password + salt).hex
}
