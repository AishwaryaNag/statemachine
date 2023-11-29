import java.io.PrintStream;

public final class EmergencyServiceContext
    extends FSMContext
{
//---------------------------------------------------------------
// Member methods.
//

    public EmergencyServiceContext(EmergencyService owner)
    {
        super();

        _owner = owner;
        setState(EmergencyServiceFSM.Reported);
        EmergencyServiceFSM.Reported.Entry(this);
    }

    public EmergencyServiceState getState()
        throws StateUndefinedException
    {
        if (_state == null)
        {
            throw(
                new StateUndefinedException());
        }

        return ((EmergencyServiceState) _state);
    }

    protected EmergencyService getOwner()
    {
        return (_owner);
    }

//---------------------------------------------------------------
// Member data.
//

    transient private EmergencyService _owner;

//---------------------------------------------------------------
// Inner classes.
//

    public static abstract class EmergencyServiceState
        extends State
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected EmergencyServiceState(String name, int id)
        {
            super (name, id);
        }

        protected void Entry(EmergencyServiceContext context) {}
        protected void Exit(EmergencyServiceContext context) {}

        protected void Default(EmergencyServiceContext context)
        {
            if (context.getDebugFlag() == true)
            {
                PrintStream str = 
                    context.getDebugStream();

                str.println(
                    "TRANSITION   : Default");
            }

            throw (
                new TransitionUndefinedException(
                    "State: " +
                    context.getState().getName() +
                    ", Transition: " +
                    context.getTransition()));
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }

    /* package */ static abstract class EmergencyServiceFSM
    {
    //-----------------------------------------------------------
    // Member methods.
    //

    //-----------------------------------------------------------
    // Member data.
    //

        //-------------------------------------------------------
        // Statics.
        //
        public static EmergencyServiceFSM_Default.EmergencyServiceFSM_Reported Reported;
        public static EmergencyServiceFSM_Default.EmergencyServiceFSM_Final Final;
        private static EmergencyServiceFSM_Default Default;

        static
        {
            Reported = new EmergencyServiceFSM_Default.EmergencyServiceFSM_Reported("EmergencyServiceFSM.Reported", 3);
            Final = new EmergencyServiceFSM_Default.EmergencyServiceFSM_Final("EmergencyServiceFSM.Final", 4);
            Default = new EmergencyServiceFSM_Default("EmergencyServiceFSM.Default", -1);
        }

    }

    protected static class EmergencyServiceFSM_Default
        extends EmergencyServiceState
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected EmergencyServiceFSM_Default(String name, int id)
        {
            super (name, id);
        }

    //-----------------------------------------------------------
    // Inner classse.
    //


        private static final class EmergencyServiceFSM_Reported
            extends EmergencyServiceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private EmergencyServiceFSM_Reported(String name, int id)
            {
                super (name, id);
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class EmergencyServiceFSM_Final
            extends EmergencyServiceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private EmergencyServiceFSM_Final(String name, int id)
            {
                super (name, id);
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }
}
