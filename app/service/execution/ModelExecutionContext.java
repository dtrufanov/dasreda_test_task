package service.execution;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;

public class ModelExecutionContext extends CustomExecutionContext {

    @Inject
    public ModelExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, "model.repository");
    }
}
