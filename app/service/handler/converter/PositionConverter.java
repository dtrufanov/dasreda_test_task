package service.handler.converter;

import model.Position;
import model.to.PositionTO;

public class PositionConverter extends Converter<Position, PositionTO> {
    private BrandConverter brandConverter = new BrandConverter();
    private ModelConverter modelConverter = new ModelConverter();

    @Override
    public Position toEntity(PositionTO to) {
        Position position = new Position();
        position.setId(to.getId());
        position.setBrand(brandConverter.toEntity(to.getBrand()));
        position.setModel(modelConverter.toEntity(to.getModel()));
        position.setYearOfIssue(to.getYearOfIssue());
        position.setMileage(to.getMileage());
        position.setPrice(to.getPrice());

        return position;
    }

    @Override
    public PositionTO toTO(Position position) {
        PositionTO to = new PositionTO();
        to.setId(position.getId());
        to.setBrand(brandConverter.toTO(position.getBrand()));
        to.setModel(modelConverter.toTO(position.getModel()));
        to.setYearOfIssue(position.getYearOfIssue());
        to.setMileage(position.getMileage());
        to.setPrice(position.getPrice());
        return to;
    }
}
