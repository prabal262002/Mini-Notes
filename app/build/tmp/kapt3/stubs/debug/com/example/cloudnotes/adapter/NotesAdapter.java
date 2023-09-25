package com.example.cloudnotes.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/cloudnotes/adapter/NotesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/cloudnotes/adapter/NotesAdapter$NotesViewHolder;", "notesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/cloudnotes/entities/Notes;", "(Lkotlinx/coroutines/flow/Flow;)V", "arrList", "onItemClickListener", "Lkotlin/Function1;", "", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnClickListener", "listener", "Lcom/example/cloudnotes/adapter/NotesAdapter$OnItemClickListener;", "NotesViewHolder", "OnItemClickListener", "app_debug"})
public final class NotesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.cloudnotes.adapter.NotesAdapter.NotesViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cloudnotes.entities.Notes>> notesFlow = null;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemClickListener;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.example.cloudnotes.entities.Notes> arrList;
    
    public NotesAdapter(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.Flow<? extends java.util.List<com.example.cloudnotes.entities.Notes>> notesFlow) {
        super();
    }
    
    public final void setOnClickListener(@org.jetbrains.annotations.NotNull
    com.example.cloudnotes.adapter.NotesAdapter.OnItemClickListener listener) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.cloudnotes.adapter.NotesAdapter.NotesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.cloudnotes.adapter.NotesAdapter.NotesViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/cloudnotes/adapter/NotesAdapter$NotesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/cloudnotes/databinding/ItemRvNotesBinding;", "onItemClickListener", "Lkotlin/Function1;", "", "", "(Lcom/example/cloudnotes/databinding/ItemRvNotesBinding;Lkotlin/jvm/functions/Function1;)V", "bind", "note", "Lcom/example/cloudnotes/entities/Notes;", "app_debug"})
    public static final class NotesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.cloudnotes.databinding.ItemRvNotesBinding binding = null;
        @org.jetbrains.annotations.Nullable
        private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onItemClickListener = null;
        
        public NotesViewHolder(@org.jetbrains.annotations.NotNull
        com.example.cloudnotes.databinding.ItemRvNotesBinding binding, @org.jetbrains.annotations.Nullable
        kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemClickListener) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.example.cloudnotes.entities.Notes note) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/cloudnotes/adapter/NotesAdapter$OnItemClickListener;", "Lkotlin/Function1;", "", "", "onClicked", "noteId", "app_debug"})
    public static abstract interface OnItemClickListener extends kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> {
        
        public abstract void onClicked(int noteId);
    }
}