package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.cards.com.ArtemisSupportFire;
import Hades.enums.hadesCards;
import Hades.powers.DoomPower;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.watcher.TriggerMarksAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class ArtemisFullyLoaded extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ArtemisFullyLoaded.class.getSimpleName(),
            COSTS[2],
            AbstractCard.CardType.SKILL,
            CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int CARDS = 1;
    private static final int UPG_CARDS = 1;
    public ArtemisFullyLoaded() {
        super(cardInfo, false);
        setMagic(CARDS, UPG_CARDS);
        tags.add(hadesCards.ARTEMIS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { atb(new MakeTempCardInDrawPileAction(new ArtemisSupportFire(), magicNumber, true, true)); }
}
