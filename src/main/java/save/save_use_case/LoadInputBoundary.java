package save.save_use_case;

public interface LoadInputBoundary {
    LoadResponse performLoad(LoadRequest loadRequest);

    LoadResponse performQuickLoad(LoadRequest loadRequest);
}

