package au.com.belmonttechnology.data

import reflect.BeanProperty
import javax.persistence.Entity

@Entity
class Customer extends AbstractEntity {
  @BeanProperty
  var name: String = null;
}
