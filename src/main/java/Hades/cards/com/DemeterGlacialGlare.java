package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;


public class DemeterGlacialGlare extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            DemeterGlacialGlare.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 12;
    private static final int UPG_BLOCK = 3;
    private static final int THORNS = 1;
    public DemeterGlacialGlare() {
        super(cardInfo, false);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(THORNS);
        this.tags.add(hadesCards.DEMETER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDef(block);
        doPow(p, new ThornsPower(p, magicNumber));
    }
}
