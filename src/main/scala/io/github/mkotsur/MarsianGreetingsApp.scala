package io.github.mkotsur

import cats.effect.{ExitCode, IO, IOApp}
import io.github.mkotsur.greeter.Greeter
import io.github.mkotsur.user.{Profile, User}

import scala.util.Random

object MarsianGreetingsApp extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {

    val user: User = User("miccots@gmail.com", "Mike")

    for {
      random <- IO.delay(new Random)
      fetchProfile = Profile.fetchProfileRandom(random)
      profile <- fetchProfile(user)
      greet = Greeter.languageAwareGreeter(profile.languagePref)
      _ <- greet(user)
    } yield ExitCode.Success

  }
}
