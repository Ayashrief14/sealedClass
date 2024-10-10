sealed class Contact {
    class Person(val name: String?, val phoneNumber: String?)
    class Business(val businessName: String?, val email: String?)
}

enum class ContactType {
    PERSON,
    BUSINESS
}
// when setting contactData type to Contact , contactInfo in line 40 can't accept personContact (required : Contact , found : Contact.Person ) so I made two different  classes
data class ContactInfoForBusiness(
    val contactType: ContactType,
    val contactData : Contact.Business
){
    fun printContactInfo(){
        if (contactData.businessName == null || contactData.email == null){
            println(" please check your data ")
        }else{
            println("Business name: ${contactData.businessName}, Business email ${contactData.email}")
        }
    }
}

data class ContactInfoForPerson(
    val contactType: ContactType,
    val contactData: Contact.Person
){
    fun printContactInfo(){
        if (contactData.name == null || contactData.phoneNumber == null){
            println(" please check your data ")
        }else{
            println("Person Name: ${contactData.name}, Phone Number ${contactData.phoneNumber}")
        }
    }
}

    fun main() {
        val personContact = Contact.Person("Ahmed", "01011111111")
        val businessContact = Contact.Business("Samsung", "samsung@gmail.com")
        val personContactInfo = ContactInfoForPerson(ContactType.PERSON,personContact)
        val businessContactInfo = ContactInfoForBusiness(ContactType.BUSINESS,businessContact)
        personContactInfo.printContactInfo()
        businessContactInfo.printContactInfo()

    }