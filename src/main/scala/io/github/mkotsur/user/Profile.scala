package io.github.mkotsur.user

import cats.effect.IO

import scala.util.Random

object Profile {

  type FetchProfile = User => IO[Profile]

  def fetchProfileRandom(random: Random): FetchProfile =
    _ =>
      IO(
        if (random.nextBoolean())
          Profile(LanguagePref.English)
        else
          Profile(LanguagePref.French)
    )
}

case class Profile(languagePref: LanguagePref)
