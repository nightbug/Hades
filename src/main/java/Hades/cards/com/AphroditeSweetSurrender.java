package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AphroditeSweetSurrender extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AphroditeSweetSurrender.class.getSimpleName(),
            COSTS[3],
            CardType.SKILL,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int VULNERABLE = 1;
    private static final int UPG_COST = 2;
    public AphroditeSweetSurrender() {
        super(cardInfo, false);
        setMagic(VULNERABLE);
        setHadesMagic(0);
        setCostUpgrade(UPG_COST);
        tags.add(hadesCards.APHRODITE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(hadesSecondMagicNumber > 0){ doPow(m, new VulnerablePower(m, hadesSecondMagicNumber, false)); }
    }
    public void calculateCardDamage(AbstractMonster m){
        super.calculateCardDamage(m);
        AbstractPower p = m.getPower(WeakPower.POWER_ID);
        if(p != null){ hadesSecondMagicNumber = p.amount; }
        else { hadesSecondMagicNumber = hadesBaseSecondMagicNumber; }
        isHADESSecondMagicNumberModified = (hadesSecondMagicNumber != hadesBaseSecondMagicNumber);
        String desc = cardStrings.DESCRIPTION;
        if(isHADESSecondMagicNumberModified){ desc += cardStrings.EXTENDED_DESCRIPTION[0]; }
        rawDescription = desc;
        initializeDescription();
    }
}