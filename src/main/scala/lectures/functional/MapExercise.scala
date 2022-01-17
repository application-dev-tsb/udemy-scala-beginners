package lectures.functional

object MapExercise extends App {

  /**
   * overly simplified social network:
   * Person = String
   * - add a person to the network
   * - remove
   * - friend (mutual)
   * - unfriend
   *
   * - number of friends
   * - person with most friends
   * - how many people have no friends
   * - if there is a social connection between two people
   */

  //our definition
  type Person = String
  type SocialNetwork = Map[Person, List[Person]]
  var socialNetwork: SocialNetwork = Map()

  def addPerson(network: SocialNetwork, person: Person): SocialNetwork = ???
}
