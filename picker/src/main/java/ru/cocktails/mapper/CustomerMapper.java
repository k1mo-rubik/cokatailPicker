package ru.cocktails.mapper;


import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.cocktails.customer.model.entity.Customer;

@Mapper(componentModel = "spring",
injectionStrategy = InjectionStrategy.FIELD
)
public abstract class CustomerMapper {

    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    public abstract Customer fromCustomerDto(Customer customer);

}
