package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AthenaBronze extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AthenaBronze.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 12;
    private static final int THORNS = 1;
    private static final int UPG_THORNS = 1;
    public AthenaBronze() {
        super(cardInfo, false);
        setBlock(BLOCK);
        setMagic(THORNS, UPG_THORNS);
        this.tags.add(hadesCards.ATHENA);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDef(this.block);
        doPow(p, new ThornsPower(p, magicNumber));
    }
}
