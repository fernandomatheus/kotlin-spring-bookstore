package com.bookstore.model

import com.bookstore.enums.BookStatus
import com.bookstore.enums.Errors
import com.bookstore.exception.BadRequestException
import java.math.BigDecimal
import javax.persistence.*

@Entity(name = "book")
data class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: BigDecimal,

    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel? = null
) {
    @Column
    @Enumerated(EnumType.STRING)
    var status: BookStatus? = null
        set(value) {
            if(field == BookStatus.CANCELED || field == BookStatus.DELETED)
                throw BadRequestException(Errors.KSB101.message.format(id), Errors.KSB101.code)

            field = value
        }

    constructor(
        id: Int? = null,
        name: String,
        price: BigDecimal,
        customer: CustomerModel? = null,
        status: BookStatus?): this(id, name, price, customer) {
            this.status = status
        }
}