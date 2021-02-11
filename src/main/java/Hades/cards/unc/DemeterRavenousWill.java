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
import com.megacrit.cardcrawl.powers.MetallicizePower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class DemeterRavenousWill extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            DemeterRavenousWill.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int STR = 2;
    private static final int METAL = 2;

    public DemeterRavenousWill() {
        super(cardInfo, false);
        setMagic(STR);
        setHadesMagic(METAL);
        setExhaust(true, false);
        this.tags.add(hadesCards.DEMETER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doPow(p, new StrengthPower(p, magicNumber));
        doPow(p, new MetallicizePower(p, hadesSecondMagicNumber));
    }
}
