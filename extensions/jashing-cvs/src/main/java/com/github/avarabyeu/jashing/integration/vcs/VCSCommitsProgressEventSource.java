package com.github.avarabyeu.jashing.integration.vcs;

import com.github.avarabyeu.jashing.core.EventSource;
import com.github.avarabyeu.jashing.core.eventsource.ScheduledEventSource;
import com.github.avarabyeu.jashing.events.NumberEvent;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

/**
 * @author Andrey Vorobyov
 */
@EventSource(value = "vcs-commits-progress-source", explicitConfiguration = AbstractVcsModule.class)
public class VCSCommitsProgressEventSource extends ScheduledEventSource<NumberEvent> {

    @Inject
    private VCSClient vcsClient;

    /* recalculate yesterday commits count each hour. Think about better approach of expiration policy*/
    private final Supplier<Long> yestardayCommitsCount = Suppliers.memoizeWithExpiration(new Supplier<Long>() {
        @Override
        public Long get() {
            LocalDate today = LocalDate.now();
            return vcsClient.getCommitsForPeriod(today.minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant(),
                    today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }
    }, 1, TimeUnit.HOURS);


    @Override
    protected NumberEvent produceEvent() {
        Instant fromDateTime = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        Long todaysCommitsCount = vcsClient.getCommitsForPeriod(fromDateTime);
        return new NumberEvent(todaysCommitsCount.intValue(), yestardayCommitsCount.get().intValue());
    }
}
