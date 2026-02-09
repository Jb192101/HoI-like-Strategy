package org.jedi_bachelor.strategy.economics.buildings.classes;

import org.jedi_bachelor.strategy.economics.buildings.interfaces.Producer;
import org.jedi_bachelor.strategy.economics.buildings.interfaces.Trader;
import org.jedi_bachelor.strategy.economics.enums.ProductionEnum;
import org.jedi_bachelor.strategy.economics.enums.ResourceEnum;

import java.util.Map;

abstract public class AbstractProducer implements Trader, Producer {
    protected Integer productsCount;
    protected ProductionEnum product;
    protected Map<ResourceEnum, Integer> resources;

    @Override
    public void produce() {
        for(int i = 0; i < 5; i++) {
            if(haveResourcesForProduct()) {
                productsCount++;
                for(ResourceEnum r : resources.keySet()) {
                    resources.put(r, resources.get(r) - product.getResourceCount(r));
                }
            }
        }
    }

    @Override
    public void trade(int cost, int countForOne) {

    }

    protected boolean haveResourcesForProduct() {
        for(ResourceEnum r : this.resources.keySet()) {
            if(product.getResourceCount(r) > this.resources.get(r)) {
                return false;
            }
        }
        return true;
    }
}
