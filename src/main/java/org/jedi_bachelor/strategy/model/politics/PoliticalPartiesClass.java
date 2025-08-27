package org.jedi_bachelor.strategy.model.politics;

public class PoliticalPartiesClass {
    private int leftDemocraticPopularity;
    private int rightDemocraticPopularity;
    private int radicalLeftPopularity;
    private int radicalRightPopularity;
    private int centrismPopularity;

    public PoliticalPartiesClass(int radLeft, int demLeft, int centrism, int demRight, int radRight) {
        int onePercent = (radLeft + demLeft + centrism + demRight + radRight) / 100;

        this.leftDemocraticPopularity = demLeft / onePercent;
        this.radicalLeftPopularity = radLeft / onePercent;
        this.centrismPopularity = centrism / onePercent;
        this.rightDemocraticPopularity = demRight / onePercent;
        this.radicalRightPopularity = radRight / onePercent;

        if(this.leftDemocraticPopularity + this.radicalLeftPopularity + this.radicalRightPopularity + this.rightDemocraticPopularity
        + this.centrismPopularity < 100) {
            this.centrismPopularity += 100 - (this.leftDemocraticPopularity + this.radicalLeftPopularity + this.radicalRightPopularity + this.rightDemocraticPopularity
                    + this.centrismPopularity);
        }
    }
}
