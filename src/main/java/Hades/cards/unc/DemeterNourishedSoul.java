package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class DemeterNourishedSoul extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            DemeterNourishedSoul.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int UPG_COST = 0;
    public DemeterNourishedSoul() {
        super(cardInfo, false);
        setCostUpgrade(UPG_COST);
        setExhaust(true);
        this.tags.add(hadesCards.DEMETER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new AbstractGameAction() {
            @Override
            public void update() {
                for(AbstractPower pow : p.powers){
                    if(pow.type == AbstractPower.PowerType.DEBUFF){ att(new RemoveSpecificPowerAction(p, p, pow)); }
                }
                this.isDone = true;
            }
        });
    }
}
