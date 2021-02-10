package Hades.cards.unc;

import Hades.cards.abs.abs_hades_card;
import Hades.enums.hadesCards;
import Hades.powers.DoomPower;
import Hades.util.CardInfo;
import com.evacipated.cardcrawl.mod.stslib.powers.StunMonsterPower;
import com.megacrit.cardcrawl.actions.watcher.TriggerMarksAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static Hades.Hades.makeID;
import static Hades.util.actionShortcuts.*;

public class AphroditeUnhealthyFixation extends abs_hades_card {
    private final static CardInfo cardInfo = new CardInfo(
            AresCurseOfPain.class.getSimpleName(),
            COSTS[3],
            AbstractCard.CardType.SKILL,
            CardTarget.ENEMY
    );
    public static final String ID = makeID(cardInfo.cardName);
    private static final int CHARM = 1;
    private static final int UPG_COST = 2;
    public AphroditeUnhealthyFixation() {
        super(cardInfo, false);
        setMagic(CHARM);
        setCostUpgrade(UPG_COST);
        tags.add(hadesCards.APHRODITE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) { doPow(m, new StunMonsterPower(m, magicNumber)); }
}
