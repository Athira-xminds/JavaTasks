public class Bonus{
    public static void main(String[] args){
        BonusCalculator bonusHr = (salary) -> ((salary*10.0)/100);
        BonusCalculator bonusDeveloper = (salary) -> ((salary*20.0)/100);
        BonusCalculator bonusSales = (salary) -> ((salary*15.0)/100);
        BonusCalculator bonusTester = (salary) -> ((salary*12.0)/100);

        System.out.println(bonusHr.calculateBonus(50000.0));
        bonusHr.displayEmployee("Ram");
        System.out.println(bonusDeveloper.calculateBonus(50000.0));
        bonusDeveloper.displayEmployee("John");
        System.out.println(bonusSales.calculateBonus(50000.0));
        bonusSales.displayEmployee("Veena");
        System.out.println(bonusTester.calculateBonus(50000.0));
        bonusTester.displayEmployee("Sandhya");
        BonusCalculator.companyPolicy();
    }

}
