package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class DemeterMistralDash extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            DemeterMistralDash.class.getSimpleName(),
            COSTS[3],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 12;
    private static final int UPG_BLOCK = 3;
    private static final int DRAW = 2;
    private static final int UPG_DRAW = 1;
    public DemeterMistralDash() {
        super(cardInfo, false);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(DRAW, UPG_DRAW);
        tags.add(hadesCards.DEMETER);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        doDef(block);
        doDraw(magicNumber);
    }
}
