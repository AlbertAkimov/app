package bertos.net.shop.dto;

import bertos.net.shop.model.AbstractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * @Authot: Albert Akimov
 * @Date: 05.07.2020
 * @Description:
 */
@MappedSuperclass
public abstract class AbstractMapper<D extends AbstractDataTransferObject, E extends AbstractEntity> {

    @Autowired
    protected final ModelMapper modelMapper;
    protected final Class<D> classDTO;
    protected final Class<E> classEntity;

    protected AbstractMapper(ModelMapper modelMapper, Class<D> classDTO, Class<E> classEntity) {
        this.modelMapper = modelMapper;
        this.classDTO = classDTO;
        this.classEntity = classEntity;
    }

    public E toEntity(D dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, classEntity);
    }

    public D toDTO(E entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, classDTO);
    }

}
