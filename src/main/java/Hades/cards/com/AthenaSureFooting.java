package Hades.cards.com;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.doDef;
import static Hades.util.actionShortcuts.doDmg;

public class AthenaSureFooting extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AthenaSureFooting.class.getSimpleName(),
            COSTS[0],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int BLOCK = 7;
    private static final int UPG_COST = 2;
    public AthenaSureFooting() {
        super(cardInfo, false);
        setBlock(BLOCK, UPG_COST);
        setRetain(true);
        this.tags.add(hadesCards.ATHENA);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doDef(this.block); }
}
