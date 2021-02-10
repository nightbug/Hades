package Hades.cards.bas;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDef;

public class HermesRecovery extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            HermesRecovery.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 12;
    private static final int UPG_BLOCK = 3;
    public HermesRecovery() {
        super(cardInfo, false);
        setBlock(BLOCK, UPG_BLOCK);
        tags.add(hadesCards.HERMES);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDef(this.block);
    }
}
