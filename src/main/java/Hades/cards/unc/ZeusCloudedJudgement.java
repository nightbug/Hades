package Hades.cards.unc;

import Hades.actions.unique.ZeusCloudedJudgment.ZeusCloudedJudgmentAction;
import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.util.CardInfo;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.atb;
import static Hades.util.actionShortcuts.att;

public class ZeusCloudedJudgement extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            ZeusCloudedJudgement.class.getSimpleName(),
            COSTS[1],
            AbstractCard.CardType.SKILL,
            AbstractCard.CardTarget.SELF
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int UPG_COST = 0;
    public ZeusCloudedJudgement() {
        super(cardInfo, false);
        setCostUpgrade(UPG_COST);
        this.tags.add(hadesCards.ZEUS);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ZeusCloudedJudgmentAction(p.hand.size()));
    }
}